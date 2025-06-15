public class Report {
    private double totalDOM = 0;
    private double totalASIA = 0;
    private double totalWORLD = 0;
    public double domDuration = 0;
    public double asiaDuration = 0;
    public double worldDuration = 0;
    private double sport_DOM;
    private double sport_ASIA;
    private double sport_WORLD;
    private double depedents_DOM;
    private double depedents_ASIA;
    private double depedents_WORLD;

    // Getters
    public double getTotalDOM() {
        return totalDOM;
    }
    public double getTotalAsia() {
        return totalASIA;
    }

    public double getTotalWorld() {
        return totalWORLD;
    }

    public double getDepedentsDOM() {
        return depedents_DOM;
    }

    public double getDepedentsASIA() {
        return depedents_ASIA;
    }

    public double getDepedentsWORLD() {
        return depedents_WORLD;
    }

      public double getSportDOM() {
        return sport_DOM;
    }

    public double getSportASIA() {
        return sport_ASIA;
    }

    public double getSportWORLD() {
        return sport_WORLD;
    }

    // Setters
    public void setDuration_DOM(double domDuration){
        this.domDuration = domDuration;
    }

    public void setDuratioon_Asia(double asiaDuration){
        this.asiaDuration = asiaDuration;
    }

    public void setDuration_World(double worldDuration){
        this.worldDuration = worldDuration;
    }
    

    public void setTotalDOM(double totalDOM) {
        this.totalDOM = totalDOM;
    }

    public void setTotalASIA(double totalASIA) {
        this.totalASIA = totalASIA;
    }

    public void setTotalWORLD(double totalWORLD) {
        this.totalWORLD = totalWORLD;
    }

    public void setSportDOM(double sport_DOM) {
        this.sport_DOM = sport_DOM;
    }

    public void setSportASIA(double sport_ASIA) {
        this.sport_ASIA = sport_ASIA;
    }

    public void setSportWORLD(double sport_WORLD) {
        this.sport_WORLD = sport_WORLD;
    }

    public void setDepedentsDOM(double depedents_DOM) {
        this.depedents_DOM = depedents_DOM;
    }

    public void setDepedentsASIA(double depedents_ASIA) {
        this.depedents_ASIA = depedents_ASIA;
    }

    public void setDepedentsWORLD(double depedents_WORLD) {
        this.depedents_WORLD = depedents_WORLD;
    }  

    public void sumTotalDOM(double total){
        totalDOM += total;
    }
    
    public void sumSportDOM(double total){
        sport_DOM += total;
    }
    
    public void sumDepedentsDOM(double total){
        depedents_DOM += total;
    }

        public void sumTotalASIA(double total){
        totalASIA += total;
    }

    public void sumSportASIA(double total){
        sport_ASIA += total;
    }

    public void sumDepedentsASIA(double total){
        depedents_ASIA += total;
    }

    public void sumTotalWORLD(double total){
        totalWORLD += total;
    }

    public void sumSportWORLD(double total){
        sport_WORLD += total;
    }

    public void sumDepedentsWORLD(double total){
        depedents_WORLD += total;
    }


    

    public String toString(){
        return "\n \t\t\t\t\t\t\t\t SUMMARY REPORT" +
        "\n   +----------------------------------------------------------------------------------------------------------------------------------------------+\n" + 
        "\tDestination \t Basic Insurance Fee(MYR)\tExtreme Sport Coverage (MYR)\t Family Coverage (MYR)\t  Total(Including additional Fee)\n" +
        String.format("\n\tDomestic \t %.2f  \t\t\t\t%.2f  \t\t\t\t%.2f     \t\t  %.2f", domDuration,sport_DOM,depedents_DOM,totalDOM) +
        String.format("\n\tAsia \t\t %.2f  \t\t\t\t%.2f  \t\t\t\t%.2f     \t\t  %.2f", asiaDuration,sport_ASIA,depedents_ASIA,totalASIA) +
        String.format("\n\tDomestic \t %.2f  \t\t\t\t%.2f  \t\t\t\t%.2f     \t\t  %.2f", worldDuration,sport_WORLD,depedents_WORLD,totalWORLD)+ 
        "\n    +----------------------------------------------------------------------------------------------------------------------------------------------+\n";
    }
    
}
