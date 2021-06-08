package vo;

public class userInfo {
    private String id;              // 아이디
    private String name;            // 이름
    private String studyDate;       // 스터디날짜
    private String chapter;         // 챕터
    private String homework;        // 과제
    private String middleMeetings;  // 중간점검참석
    private String weekMeeting;     // 일주일점검참석
    private String deposit;         // 보증금

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudyDate(String studyDate) {
        this.studyDate = studyDate;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public void setMiddleMeetings(String middleMeetings) {
        this.middleMeetings = middleMeetings;
    }

    public void setWeekMeeting(String weekMeeting) {
        this.weekMeeting = weekMeeting;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStudyDate() {
        return studyDate;
    }

    public String getChapter() {
        return chapter;
    }

    public String getHomework() {
        return homework;
    }

    public String getMiddleMeetings() {
        return middleMeetings;
    }

    public String getWeekMeeting() {
        return weekMeeting;
    }

    public String getDeposit() {
        return deposit;
    }
}
