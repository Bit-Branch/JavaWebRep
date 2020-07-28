package by.epam.committiee.entity;

public class Result {
    private long id;
    private int certificateMark;
    private int firstExamMark;
    private int secondExamMark;
    private int thirdExamMark;
    private int fourthExamMark;
    private boolean isCredited;

    public Result() {
    }

    public Result(long id, int certificateMark, int firstExamMark, int secondExamMark, int thirdExamMark, int fourthExamMark, boolean isCredited) {
        this.id = id;
        this.certificateMark = certificateMark;
        this.firstExamMark = firstExamMark;
        this.secondExamMark = secondExamMark;
        this.thirdExamMark = thirdExamMark;
        this.fourthExamMark = fourthExamMark;
        this.isCredited = isCredited;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCertificateMark() {
        return certificateMark;
    }

    public void setCertificateMark(int certificateMark) {
        this.certificateMark = certificateMark;
    }

    public int getFirstExamMark() {
        return firstExamMark;
    }

    public void setFirstExamMark(int firstExamMark) {
        this.firstExamMark = firstExamMark;
    }

    public int getSecondExamMark() {
        return secondExamMark;
    }

    public void setSecondExamMark(int secondExamMark) {
        this.secondExamMark = secondExamMark;
    }

    public int getThirdExamMark() {
        return thirdExamMark;
    }

    public void setThirdExamMark(int thirdExamMark) {
        this.thirdExamMark = thirdExamMark;
    }

    public int getFourthExamMark() {
        return fourthExamMark;
    }

    public void setFourthExamMark(int fourthExamMark) {
        this.fourthExamMark = fourthExamMark;
    }

    public boolean isCredited() {
        return isCredited;
    }

    public void setCredited(boolean credited) {
        isCredited = credited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        return isCredited == result.isCredited && id == result.id &&
                certificateMark == result.certificateMark && firstExamMark == result.firstExamMark &&
                secondExamMark == result.secondExamMark && thirdExamMark == result.thirdExamMark &&
                fourthExamMark == result.fourthExamMark;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + certificateMark;
        result = 31 * result + firstExamMark;
        result = 31 * result + secondExamMark;
        result = 31 * result + thirdExamMark;
        result = 31 * result + fourthExamMark;
        result = 31 * result + (isCredited ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getName());
        stringBuilder.append("@ id:");
        stringBuilder.append(id);
        stringBuilder.append(", certificateMark: ");
        stringBuilder.append(certificateMark);
        stringBuilder.append(", firstExamMark: ");
        stringBuilder.append(firstExamMark);
        stringBuilder.append(", secondExamMark: ");
        stringBuilder.append(secondExamMark);
        stringBuilder.append(", thirdExamMark: ");
        stringBuilder.append(thirdExamMark);
        stringBuilder.append(", fourthExamMark: ");
        stringBuilder.append(fourthExamMark);
        stringBuilder.append(", isCredited: ");
        stringBuilder.append(isCredited);
        return stringBuilder.toString();
    }
}
