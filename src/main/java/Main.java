import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args)throws IOException {
        File file = new File("C:\\Users\\21av0740\\Desktop\\topBabyNames60s.json");
        Document doc = Jsoup.connect("https://www.ssa.gov/oact/babynames/decades/names1960s.html").get();
        Elements Data = doc.select("tbody").select("td");
        TreeMap<Integer, String> dataB4 = new TreeMap<Integer, String>();
        Pattern pop = Pattern.compile("/d/d/d{3,}");
        Pattern namin = Pattern.compile("[a-zA-Z]");
        int temp =0;
        String name="";
        TreeMap<Integer,String> map = new TreeMap<Integer, String>();

        ObjectMapper mapin = new ObjectMapper();

        ObjectWriter writin = mapin.writer(new DefaultPrettyPrinter());

        for(Element i : Data){
            Matcher r = pop.matcher(i.text());
            Matcher p = namin.matcher(i.text());
            if(r.find( ))
                continue;
            else if ((i.text().length() > 3) && !p.find()){
                temp = Integer.parseInt(i.text().replace(",", ""));
            }
            else if (p.find())
                name = i.text();
            dataB4.put(temp, name);
        }
        System.out.println(dataB4);
        file.delete();
        writin.writeValue(file, dataB4);
    }
}
