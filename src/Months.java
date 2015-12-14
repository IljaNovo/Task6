public enum Months {
    January(31, Months.February),
    February(30, Months.March),
    March(31, Months.April),
    April(30, Months.May),
    May(31, Months.June),
    June(30, Months.July),
    July(31, Months.August),
    August(31, Months.September),
    September(30, Months.October),
    October(31, Months.November),
    November(30, Months.December),
    December(31, Months.January);

    int countDays;
    Months nextMonth;

    private Months(int countDays, Months nextMonth) {
        this.countDays = countDays;
        this.nextMonth = nextMonth;
    }

    public int getCountDays() {
        return this.countDays;
    }

    public Months next() {
        return this.nextMonth;
    }
}
