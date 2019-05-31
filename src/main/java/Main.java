import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args)throws IOException {
        Document doc = Jsoup.connect("https://www.ssa.gov/oact/babynames/decades/names1960s.html").get();
        Elements Data = doc.select("tbody").select("td");
        TreeMap<Integer, String> dataB4 = new TreeMap<Integer, String>();
        Pattern pop = Pattern.compile("/d/d/d");
        Pattern namin = Pattern.compile("[a-zA-Z]");
        int temp =0;
        String name="";
        for(Element i : Data){
            Matcher r = pop.matcher(i.text());
            Matcher p = namin.matcher(i.text());
            if(r.find( ))
                continue;
            else if ((i.text().length() > 2) && !p.find()){
                temp = Integer.parseInt(i.text().replace(",", ""));
            }
            else if (p.find())
                name = i.text();
            dataB4.put(temp, name);
        }
        System.out.println(dataB4);


    }
}
