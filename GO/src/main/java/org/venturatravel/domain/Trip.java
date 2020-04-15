package org.venturatravel.domain;

public class Trip {

    private int id;                     //groups, individuals, platforms
    private String name;                //groups, individuals, platforms
    private TripType trip_type;         //groups, individuals, platforms
    private String market;              //groups
    private String start_destination;   //groups
    private String end_destination;     //groups
    private int min_pax;                //groups, platforms
    private int max_pax;                //groups, platforms
    private int total_days;             //groups
    private int total_average_pax;      //groups
    private String guidance_type;       //groups

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTrip_type(TripType trip_type) {
        this.trip_type = trip_type;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public void setStart_destination(String start_destination) {
        this.start_destination = start_destination;
    }

    public void setEnd_destination(String end_destination) {
        this.end_destination = end_destination;
    }

    public void setMin_pax(int min_pax) {
        this.min_pax = min_pax;
    }

    public void setMax_pax(int max_pax) {
        this.max_pax = max_pax;
    }

    public void setTotal_days(int total_days) {
        this.total_days = total_days;
    }

    public void setTotal_average_pax(int total_average_pax) {
        this.total_average_pax = total_average_pax;
    }

    public void setGuidance_type(String guidance_type) {
        this.guidance_type = guidance_type;
    }

    public void setAverage_cost(String average_cost) {
        this.average_cost = average_cost;
    }

    public void setMeal_comments(String meal_comments) {
        this.meal_comments = meal_comments;
    }

    public void setGeneral_comments(String general_comments) {
        this.general_comments = general_comments;
    }

    public void setHost(String host) {
        this.host = host;
    }

    private String average_cost;        //groups
    private String meal_comments;       //groups
    private String general_comments;    //groups
    private String host;                //platforms

    private Trip() {
    }

    public TripType getTrip_type() {
        return trip_type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMarket() {
        return market;
    }

    public String getStart_destination() {
        return start_destination;
    }

    public String getEnd_destination() {
        return end_destination;
    }

    public int getMin_pax() {
        return min_pax;
    }

    public int getMax_pax() {
        return max_pax;
    }

    public int getTotal_days() {
        return total_days;
    }

    public int getTotal_average_pax() {
        return total_average_pax;
    }

    public String getGuidance_type() {
        return guidance_type;
    }

    public String getAverage_cost() {
        return average_cost;
    }

    public String getMeal_comments() {
        return meal_comments;
    }

    public String getGeneral_comments() {
        return general_comments;
    }

    public String getHost() {
        return host;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "Id=" + id +
                ", Name=" + name +
                ", Type=" + trip_type +
                ", Market=" + market +
                ", StartDestination=" + start_destination +
                ", EndDestination=" + end_destination +
                ", MinPax=" + min_pax +
                ", MaxPax=" + max_pax +
                ", totalDays=" + total_days +
                ", totalAveragePax=" + total_average_pax +
                ", guidanceType=" + guidance_type +
                ", averageCost=" + average_cost +
                ", mealComments=" + meal_comments +
                ", generalComments=" + general_comments +
                ", host=" + host +
                "}";
    }

    public static class Builder {
        private Trip trip;

        public Builder(int id, String name) {

            trip = new Trip();
            trip.id = id;
            trip.name = name;
        }

        public BuilderGroup setTypeGroup(String market){

            trip.market = market;
            return new Trip.BuilderGroup(trip);
        }

        public BuilderIndividual setTypeIndividual(String market){

            trip.market = market;
            return new Trip.BuilderIndividual(trip);
        }

        public BuilderPlatform setTypePlatform(String market){

            trip.market = market;
            return new Trip.BuilderPlatform(trip);
        }
    }

    public static class BuilderGroup{

        private Trip trip;

        private BuilderGroup(Trip trip){

            this.trip = trip;
            this.trip.trip_type = TripType.Groups;
        }


        public BuilderGroup setStartDestination(String start_destination){

            trip.start_destination = start_destination;
            return this;
        }

        public BuilderGroup setEndDestination(String end_destination){

            trip.end_destination = end_destination;
            return this;
        }

        public BuilderGroup setMinPax(int min_pax){

            trip.min_pax = min_pax;
            return this;
        }

        public BuilderGroup setMaxPax(int max_pax){

            trip.max_pax = max_pax;
            return this;
        }

        public BuilderGroup setTotalDays(int total_days){

            trip.total_days = total_days;
            return this;
        }

        public BuilderGroup setTotalAveragePax(int total_average_pax){

            trip.total_average_pax = total_average_pax;
            return this;
        }

        public BuilderGroup setGuidanceType(String guidance_type){

            trip.guidance_type = guidance_type;
            return this;
        }

        public BuilderGroup setAverageCost(String average_cost){

            trip.average_cost = average_cost;
            return this;
        }

        public BuilderGroup setMealComments(String meal_comments){

            trip.meal_comments = meal_comments;
            return this;
        }

        public BuilderGroup setGeneralComments(String general_comments){

            trip.general_comments = general_comments;
            return this;
        }

        public Trip build(){

            return trip;
        }
    }

    public static class BuilderIndividual{

        private Trip trip;

        private BuilderIndividual(Trip trip){

            this.trip = trip;
            this.trip.trip_type = TripType.Individuals;
        }

        public Trip build(){

            return trip;
        }
    }

    public static class BuilderPlatform{
        private Trip trip;

        private BuilderPlatform(Trip trip){
            this.trip = trip;
            this.trip.trip_type = TripType.Platforms;
        }

        public BuilderPlatform setMinPax(int min_pax){

            trip.min_pax = min_pax;
            return this;
        }

        public BuilderPlatform setMaxPax(int max_pax){

            trip.max_pax = max_pax;
            return this;
        }

        public BuilderPlatform setHost(String host){

            trip.host = host;
            return this;
        }

        public Trip build(){

            return trip;
        }
    }



}

