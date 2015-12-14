public enum Months {

    January(31) {
        public Months getNextMonth() {
            return February;
        }
    },
    February(30) {
        public Months getNextMonth() {
            return March;
        }
    },
    March(31) {
        public Months getNextMonth() {
            return April;
        }
    },
    April(30) {
        public Months getNextMonth() {
            return May;
        }
    },
    May(31) {
        public Months getNextMonth() {
            return June;
        }
    },

    June(30) {
        public Months getNextMonth() {
            return July;
        }
    },

    July(31) {
        public Months getNextMonth() {
            return August;
        }
    },
    August(31) {
        public Months getNextMonth() {
            return September;
        }
    },
    September(30) {
        public Months getNextMonth() {
            return October;
        }
    },
    October(31) {
        public Months getNextMonth() {
            return November;
        }
    },
    November(30) {
        public Months getNextMonth() {
            return October;
        }
    },
    December(31) {
        public Months getNextMonth() {
            return January;
        }
    };

    int countDays;

    private Months(int countDays) {
        this.countDays = countDays;
    }

    public int getCountDays() {
        return this.countDays;
    }

    public abstract Months getNextMonth();
}