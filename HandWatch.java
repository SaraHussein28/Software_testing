public class HandWatch {
    String state;
    String state1;
    int m, h, D, M, Y;

    public HandWatch() {
    reset();
    }
    public void reset() {
        setNormal();
        m=0; h=0; D=1; M=1; Y=2000;
    }
    public void setNormal(){
        state= "NORMAL";
        state1= "TIME";
    }
    public void setUpdate(){
        state = "UPDATE";
        state1 = "MIN";
    }
    public void setAlarm(){
        state = "ALARM";
        state1 = "ALARM";
    }

    public void pressButton (char input) {
        switch (state) {

            case "UPDATE" -> {
                if (input == 'a') {

                    switch (state1) {
                        case "MIN" -> state1 = "HOUR";
                        case "HOUR" -> state1 = "DAY";
                        case "DAY" -> state1 = "MONTH";
                        case "MONTH" -> state1 = "YEAR";
                        case "YEAR" -> setNormal();
                    }
                }

                else if (input == 'd') setNormal();

                else if (input == 'b') {
                    if (state1.equals("MIN")) {
                        m++;
                        m %= 60;
                    }
                    if (state1.equals("HOUR")) {
                        h++;
                        h %= 24;
                    }
                    if (state1.equals("DAY")) {
                        D++;
                        D %= 32;
                    }
                    if (state1.equals("MONTH")) {
                        M++;
                        M %= 13;
                    }
                    if (state1.equals("YEAR")) {
                        Y++;
                    }
                }
                else {
                    System.out.println("Not Applicable");
                }
            }

            case "NORMAL" -> {

                if (input == 'c') setUpdate();
                else if (input == 'b') setAlarm();
                else if (input == 'a') {
                    if (state1.equals("TIME")) state1 = "DATE";
                    else state1 = "TIME";
                }
                else {
                    System.out.println("Not applicable");
                }
            }
            case "ALARM" -> {
                if (input == 'd') setNormal();
                else if (input == 'a' && state1.equals("ALARM")) state1 = "CHIME";
                else {
                    System.out.println("Not Applicable");
                }
            }
        }
    }
    public String displayDate() {
        return (Y+"-"+M+"-"+D);
    }

    public String displayTime() {
        return (h+":"+m);
    }

    public String displayCurrentState() {
        return(state + "-" + state1);
    }

}
