package Model;

import View.MainJFrame6157;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CSpider6157 {
    String url;
    String path;
    String name;
    public CSpider6157() {

    }

    public CSpider6157(String url, String path, String name) {
        this.url = url;
        this.path = path;
        this.name = name;
    }

    public String getHtml() {
        String html = "";
        try {
            html = Jsoup.connect(url).execute().body();
        } catch (IOException e) {
            System.out.println("无法解释网络地址");
            e.printStackTrace();
        }
        return html;
    }

    public List<String> getImgSrcFromHtml(String html) {
        // 创建一个List集合 动态数组
        List<String> list = new ArrayList<String>();
        // 从html里面获取<img>
        Document document = Jsoup.parse(html);
        //从Document对象里面过滤 查找class 为list的div,再找DIV里面的img
        Elements elements = document.select("div [class=list]").select("img");
        // 循环取出src的值 放入list
        for (int i = 0; i < elements.size(); i++) {
            list.add(elements.get(i).attr("src"));
        }
        return list;
    }

    public void downLoadImag(List<String> list) throws IOException {
        URL newUrl = null;
        InputStream inputStream = null;
        byte[] bs =null;
        FileOutputStream fileOutputStream = null;
        for (int i = 0; i < list.size(); i++) {
            // 一条一条图片路径取出来
            // 目标 取图片网址 里面返回回来的值
            // 创建一条连接
            try {
                newUrl = new URL(list.get(i));
                // 打开这体哦啊http连接
                HttpURLConnection httpURLConnection = (HttpURLConnection) newUrl.openConnection();
                // 获取http返回的数据(IO流)
                inputStream = httpURLConnection.getInputStream();
                // 把输入流转换成二进制(字节)
                bs = getBytesFromInputStream(inputStream);
                // 把bs写入到文件里面
                //     文件的名字 路径+图片名字
                // String filePath = this.path+"\\"+list.get(i).substring(list.get(i).lastIndexOf("/")+1);
                String filePath = this.path+"\\"+name+"\\"+"user"+i+".jpg";
                //创建文件夹
                File file=new File(this.path+"\\"+name);
                if(!file.exists()){//如果文件夹不存在
                    file.mkdir();//创建文件夹
                }
                System.out.println(filePath);
                // 文件输出流
                fileOutputStream = new FileOutputStream(new File(filePath));
                // 写入数据 bs
                fileOutputStream.write(bs);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inputStream.close();
        fileOutputStream.close();
    }

    /**
         *
         * @Title: getBytesFromInputStream
         * @Description: InputStream流转换byte[]
         * @param @param  inputStream
         * @param @return byte[]
         * @return byte[] 返回类型
         * @throws
         */
        public byte[] getBytesFromInputStream(InputStream inputStream) {
            byte[] bs = null;
            try {
                byte[] buffer = new byte[1024];
                int len = 0;
                ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
                while ((len = inputStream.read(buffer)) != -1) {
                    arrayOutputStream.write(buffer, 0, len);
                }
                bs = arrayOutputStream.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bs;
        }

    // 启动爬虫
    public void start(MainJFrame6157 mainJFrame) throws IOException {
        // 1 获取HTML 源码
        String html = getHtml();
        // 2 从 html 里面获取<img> 的src的值 <img> 有很多 list
        List<String> imgPathList = getImgSrcFromHtml(html);
        System.out.println(imgPathList);
        mainJFrame.textArea.append("爬取图片数量："+imgPathList.size()+"张图片");
        // 3 下载list里面的图片到指定文件夹
        downLoadImag(imgPathList);
    }
}
