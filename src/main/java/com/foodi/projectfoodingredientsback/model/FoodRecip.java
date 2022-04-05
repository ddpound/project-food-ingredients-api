package com.foodi.projectfoodingredientsback.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

// 음식 레시피 데베
// 사실상 최종 데베

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodRecip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipId;

    @Column(nullable = false)
    private String rcpName;

    // 검색할때 가장 중요함
    // 여기서 몇가지의 재료를 가지고 있냐에 따라 검색결과를 추천해줄듯
    // 재료들
    @Column(nullable = false , length = 800)
    private String rcpDtls;

    // 해쉬태그
    @Column(nullable = false)
    private String hashTag;

    // 완성품 사진
    @Column
    private String attFileNoMk;


    //메뉴 최대 20개
    @Column
    private String manual01;

    @Column
    private String manual02;

    @Column
    private String manual03;

    @Column
    private String manual04;

    @Column
    private String manual05;

    @Column
    private String manual06;

    @Column
    private String manual07;

    @Column
    private String manual08;

    @Column
    private String manual09;

    @Column
    private String manual10;

    @Column
    private String manual11;

    @Column
    private String manual12;

    @Column
    private String manual13;

    @Column
    private String manual14;

    @Column
    private String manual15;

    @Column
    private String manual16;

    @Column
    private String manual17;

    @Column
    private String manual18;

    @Column
    private String manual19;

    @Column
    private String manual20;

    //메뉴에 관한 사진
    @Column
    private String manualImg01;

    @Column
    private String manualImg02;

    @Column
    private String manualImg03;

    @Column
    private String manualImg04;

    @Column
    private String manualImg05;

    @Column
    private String manualImg06;

    @Column
    private String manualImg07;

    @Column
    private String manualImg08;

    @Column
    private String manualImg09;

    @Column
    private String manualImg10;

    @Column
    private String manualImg11;

    @Column
    private String manualImg12;

    @Column
    private String manualImg13;

    @Column
    private String manualImg14;

    @Column
    private String manualImg15;

    @Column
    private String manualImg16;

    @Column
    private String manualImg17;

    @Column
    private String manualImg18;

    @Column
    private String manualImg19;

    @Column
    private String manualImg20;

    @CreationTimestamp
    private Timestamp createDate;


    // getter setter


    public int getRecipId() {
        return recipId;
    }

    public void setRecipId(int recipId) {
        this.recipId = recipId;
    }

    public String getRcpName() {
        return rcpName;
    }

    public void setRcpName(String rcpName) {
        this.rcpName = rcpName;
    }

    public String getRcpDtls() {
        return rcpDtls;
    }

    public void setRcpDtls(String rcpDtls) {
        this.rcpDtls = rcpDtls;
    }

    public String getHashTag() {
        return hashTag;
    }

    public void setHashTag(String hashTag) {
        this.hashTag = hashTag;
    }

    public String getAttFileNoMk() {
        return attFileNoMk;
    }

    public void setAttFileNoMk(String attFileNoMk) {
        this.attFileNoMk = attFileNoMk;
    }

    public String getManual01() {
        return manual01;
    }

    public void setManual01(String manual01) {
        this.manual01 = manual01;
    }

    public String getManual02() {
        return manual02;
    }

    public void setManual02(String manual02) {
        this.manual02 = manual02;
    }

    public String getManual03() {
        return manual03;
    }

    public void setManual03(String manual03) {
        this.manual03 = manual03;
    }

    public String getManual04() {
        return manual04;
    }

    public void setManual04(String manual04) {
        this.manual04 = manual04;
    }

    public String getManual05() {
        return manual05;
    }

    public void setManual05(String manual05) {
        this.manual05 = manual05;
    }

    public String getManual06() {
        return manual06;
    }

    public void setManual06(String manual06) {
        this.manual06 = manual06;
    }

    public String getManual07() {
        return manual07;
    }

    public void setManual07(String manual07) {
        this.manual07 = manual07;
    }

    public String getManual08() {
        return manual08;
    }

    public void setManual08(String manual08) {
        this.manual08 = manual08;
    }

    public String getManual09() {
        return manual09;
    }

    public void setManual09(String manual09) {
        this.manual09 = manual09;
    }

    public String getManual10() {
        return manual10;
    }

    public void setManual10(String manual10) {
        this.manual10 = manual10;
    }

    public String getManual11() {
        return manual11;
    }

    public void setManual11(String manual11) {
        this.manual11 = manual11;
    }

    public String getManual12() {
        return manual12;
    }

    public void setManual12(String manual12) {
        this.manual12 = manual12;
    }

    public String getManual13() {
        return manual13;
    }

    public void setManual13(String manual13) {
        this.manual13 = manual13;
    }

    public String getManual14() {
        return manual14;
    }

    public void setManual14(String manual14) {
        this.manual14 = manual14;
    }

    public String getManual15() {
        return manual15;
    }

    public void setManual15(String manual15) {
        this.manual15 = manual15;
    }

    public String getManual16() {
        return manual16;
    }

    public void setManual16(String manual16) {
        this.manual16 = manual16;
    }

    public String getManual17() {
        return manual17;
    }

    public void setManual17(String manual17) {
        this.manual17 = manual17;
    }

    public String getManual18() {
        return manual18;
    }

    public void setManual18(String manual18) {
        this.manual18 = manual18;
    }

    public String getManual19() {
        return manual19;
    }

    public void setManual19(String manual19) {
        this.manual19 = manual19;
    }

    public String getManual20() {
        return manual20;
    }

    public void setManual20(String manual20) {
        this.manual20 = manual20;
    }

    public String getManualImg01() {
        return manualImg01;
    }

    public void setManualImg01(String manualImg01) {
        this.manualImg01 = manualImg01;
    }

    public String getManualImg02() {
        return manualImg02;
    }

    public void setManualImg02(String manualImg02) {
        this.manualImg02 = manualImg02;
    }

    public String getManualImg03() {
        return manualImg03;
    }

    public void setManualImg03(String manualImg03) {
        this.manualImg03 = manualImg03;
    }

    public String getManualImg04() {
        return manualImg04;
    }

    public void setManualImg04(String manualImg04) {
        this.manualImg04 = manualImg04;
    }

    public String getManualImg05() {
        return manualImg05;
    }

    public void setManualImg05(String manualImg05) {
        this.manualImg05 = manualImg05;
    }

    public String getManualImg06() {
        return manualImg06;
    }

    public void setManualImg06(String manualImg06) {
        this.manualImg06 = manualImg06;
    }

    public String getManualImg07() {
        return manualImg07;
    }

    public void setManualImg07(String manualImg07) {
        this.manualImg07 = manualImg07;
    }

    public String getManualImg08() {
        return manualImg08;
    }

    public void setManualImg08(String manualImg08) {
        this.manualImg08 = manualImg08;
    }

    public String getManualImg09() {
        return manualImg09;
    }

    public void setManualImg09(String manualImg09) {
        this.manualImg09 = manualImg09;
    }

    public String getManualImg10() {
        return manualImg10;
    }

    public void setManualImg10(String manualImg10) {
        this.manualImg10 = manualImg10;
    }

    public String getManualImg11() {
        return manualImg11;
    }

    public void setManualImg11(String manualImg11) {
        this.manualImg11 = manualImg11;
    }

    public String getManualImg12() {
        return manualImg12;
    }

    public void setManualImg12(String manualImg12) {
        this.manualImg12 = manualImg12;
    }

    public String getManualImg13() {
        return manualImg13;
    }

    public void setManualImg13(String manualImg13) {
        this.manualImg13 = manualImg13;
    }

    public String getManualImg14() {
        return manualImg14;
    }

    public void setManualImg14(String manualImg14) {
        this.manualImg14 = manualImg14;
    }

    public String getManualImg15() {
        return manualImg15;
    }

    public void setManualImg15(String manualImg15) {
        this.manualImg15 = manualImg15;
    }

    public String getManualImg16() {
        return manualImg16;
    }

    public void setManualImg16(String manualImg16) {
        this.manualImg16 = manualImg16;
    }

    public String getManualImg17() {
        return manualImg17;
    }

    public void setManualImg17(String manualImg17) {
        this.manualImg17 = manualImg17;
    }

    public String getManualImg18() {
        return manualImg18;
    }

    public void setManualImg18(String manualImg18) {
        this.manualImg18 = manualImg18;
    }

    public String getManualImg19() {
        return manualImg19;
    }

    public void setManualImg19(String manualImg19) {
        this.manualImg19 = manualImg19;
    }

    public String getManualImg20() {
        return manualImg20;
    }

    public void setManualImg20(String manualImg20) {
        this.manualImg20 = manualImg20;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

}
