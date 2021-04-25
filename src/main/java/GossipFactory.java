import Titles.*;

public class GossipFactory {
    public static Title getGossip(String title){
        String[]arr=title.split(" ");
        switch (arr[0]){
            case "Titles.Mr" : return new Mr(arr[1]);
            case "Titles.Dr" : return new Dr(arr[1]);
            case "Titles.Agent" : return new Agent(arr[1]);
            case "Titles.Pr" : return new Pr(arr[1]);
            case "Titles.Lady" : return new Lady(arr[1]);
            case "Titles.Sir" : return new Sir(arr[1]);
            default: return null;
        }
    }
}
