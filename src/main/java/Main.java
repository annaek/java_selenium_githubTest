import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.


       /* List<String> titles = getTitles();
        for(String title : titles) {
            System.out.println(title);
        }*/

  /*      //getPostInfo(543698);
        Map<String, List<Integer>> posts = getPostIdByTags(543698);
        for(Map.Entry<String, List<Integer>> post: posts.entrySet()) {
            List<String> idList = intToStrings(post.getValue());
            System.out.println(post.getKey()+ " " + String.join(",", idList));
        }*/

    }

    public static List<String> intToStrings(List <Integer> data){
        List<String> numbers = new ArrayList<>(data.size());
        for(Integer id : data){
            numbers.add(id.toString());
        }

        return numbers;
    }


/*    public static void getPostInfo(int id){
       WebDriver driver = DriverUtil.createDriver();
       driver.get("https://habr.com/ru/post/" + id + "/");
       List<WebElement> elements = driver.findElements(By.cssSelector("ul.post__hubs li a"));

        for(WebElement element : elements){
            System.out.println(element.getText());
        }
        driver.quit();

    }*/

    public static List<String> getTitles(){
        List<String> titles = new ArrayList<String>();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.habr.com/ru/");
        try {

            List<WebElement> elements = driver.findElements(By.cssSelector(".post__title"));

            for(WebElement element : elements){
                titles.add(element.getText());
            }

        }finally {
            driver.quit();
        }
        return titles;
    }

/*    public static Map<String, List<Integer>> getPostIdByTags(int id){
        Map<String, List<Integer>> result = new HashMap<>();
        WebDriver driver = null;
        try {
            driver = DriverUtil.createDriver();
            driver.get("https://habr.com/ru/post/" + id + "/");
            List<WebElement> tags = driver.findElements(By.cssSelector("ul.post__hubs li a"));
            Map<String, String> tagName = new HashMap<>();

            for (WebElement tag : tags) {
                tagName.put(tag.getText(), tag.getAttribute("href"));
            }


            for (Map.Entry<String, String> tag : tagName.entrySet()) {
                String name = tag.getKey();
                String url = tag.getValue();
                driver.get(url);

                List<WebElement> posts = driver.findElements(By.cssSelector("article.post h2.post__title a"));

                List<Integer> postId = new ArrayList<>();

                for (WebElement post : posts) {
                    String postLink = post.getAttribute("href");
                    //https://habr.com/ru/post/543698/
                    String[] postLinksParts = postLink.split("/");
                    String lastPart = postLinksParts[postLinksParts.length - 1];
                    int partId = Integer.parseInt(lastPart);
                    postId.add(partId);
                    //int i = 1;
                }

                result.put(name, postId);
            }
        }finally {
            if(driver!=null) {
                driver.quit();
            }
        }

        return result;

    }*/
}
