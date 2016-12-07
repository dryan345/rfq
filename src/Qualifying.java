import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;


public class Qualifying {

    private Document doc;
    ArrayList al = new ArrayList();


    public Qualifying(String series, String rd)
    {
        try {
            
            String URL = "http://racefactorygaming.com/events/2016/" + series + "/" + rd + "/qual/";
            doc = Jsoup.connect(URL).timeout(0).get();

        }
        catch (java.io.IOException ioe)
        {
            ioe.printStackTrace();
        }


    }

    // Fetches qualifying results from table
    public String fetchQualifying()
    {

        Elements results = doc.select("tr");
        //return doc.select("div[id=Results]").text();
        for (Element result : results)
        {
            al.add(result.text());
            System.out.println(al);

        }
        return "";
    }





    public static void main(String args [])
    {
        Qualifying w = new Qualifying("sxmadnesslites", "r3");

        String start = w.fetchQualifying();
        System.out.println(start);
    }
}