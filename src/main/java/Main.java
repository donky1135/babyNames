import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException {
        Document doc = Jsoup.connect("https://www.ssa.gov/oact/babynames/decades/names1960s.html").get();
        Elements Data = doc.select("tbody").select("td");
//        System.out.println(Data);
        for(Element i : Data)
            System.out.println(i.text());

    }
}
