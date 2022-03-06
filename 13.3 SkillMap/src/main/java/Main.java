import java.util.concurrent.ForkJoinPool;

public class Main {
    public static String URL = "http://www.playback.ru/";

    public static void main(String[] args) {
        SkillMap.firstURL(URL);

        int numOfThread = Runtime.getRuntime().availableProcessors();
        ForkJoinPool pool = new ForkJoinPool(numOfThread);
        for (String url : SkillMap.homePageSites) {
            pool.invoke(new SkillMap(url));
        }
    }
}
