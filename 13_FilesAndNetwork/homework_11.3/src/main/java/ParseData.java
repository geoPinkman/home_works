public class ParseData {

    private String moreInfo;
    private String income;
    private String expense;

    public ParseData(String moreInfo, String income, String expense) {
        this.moreInfo = moreInfo;
        this.income = income;
        this.expense = expense;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public String getIncome() {
        return income;
    }

    public String getExpense() {
        return expense;
    }

}
