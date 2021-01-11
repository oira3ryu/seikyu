package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="t_csv")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Csv {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="c1")
    @JsonAlias({"利用者番号","法人名","利用者番号"})
    private String c1;

    @Column(name="c2")
    @JsonAlias({"要介護度","施設名","利用者名（姓）"})
    private String c2;

    @Column(name="c3")
    @JsonAlias({"利用者名","事業所番号","利用者名（名）"})
    private String c3;

    @Column(name="c4")
    @JsonAlias({"提供月","事業所名","利用者名"})
    private String c4;

    @Column(name="c5")
    @JsonAlias({"合計額","利用者番号","フリガナ（姓）"})
    private String c5;

    @Column(name="c6")
    @JsonAlias({"サービス費（保険請求）","利用者名","フリガナ（名）"})
    private String c6;

    @Column(name="c7")
    @JsonAlias({"サービス費（公費請求）","支払方法","フリガナ"})
    private String c7;

    @Column(name="c8")
    @JsonAlias({"食費（保険請求）","引落口座","同名識別"})
    private String c8;

    @Column(name="c9")
    @JsonAlias({"食費（公費請求）","引落金融機関銀行コード","性別"})
    private String c9;

    @Column(name="c10")
    @JsonAlias({"居住費（保険請求）","引落金融機関銀行名（フリガナ）","血液型"})
    private String c10;

    @Column(name="c11")
    @JsonAlias({"居住費（公費請求）","引落金融機関銀行名","RH"})
    private String c11;

    @Column(name="c12")
    @JsonAlias({"介護請求合計額","引落金融機関支店コード","生年月日"})
    private String c12;

    @Column(name="c13")
    @JsonAlias({"利用者負担額","引落金融機関支店名（フリガナ）","郵便番号"})
    private String c13;

    @Column(name="c14")
    @JsonAlias({"自費負担額","引落金融機関支店名","住所"})
    private String c14;

    @Column(name="c15")
    @JsonAlias({"食事負担額","引落口座種別","電話番号"})
    private String c15;

    @Column(name="c16")
    @JsonAlias({"室料負担額","引落口座番号","携帯番号"})
    private String c16;

    @Column(name="c17")
    @JsonAlias({"特定公費本人支払","引落口座名義人区分","E-mail"})
    private String c17;

    @Column(name="c18")
    @JsonAlias({"高額介護超過額","引落口座名義人（フリガナ）","郵便番号（他の住所）"})
    private String c18;

    @Column(name="c19")
    @JsonAlias({"その他実費","引落口座名義人","住所（他の住所）"})
    private String c19;

    @Column(name="c20")
    @JsonAlias({"減免額","引落口座開設日","世帯区分"})
    private String c20;

    @Column(name="c21")
    @JsonAlias({"過入金","引落口座解約日","メモ"})
    private String c21;

    @Column(name="c22")
    @JsonAlias({"利用料請求合計額","引落口座メモ","統計用住所"})
    private String c22;

    @Column(name="c23")
    @JsonAlias({"敷金充当額","振込先委託者名（フリガナ）","親族・関係者名（姓）"})
    private String c23;

    @Column(name="c24")
    @JsonAlias({"振込先委託者名","親族・関係者名（名）"})
    private String c24;

    @Column(name="c25")
    @JsonAlias({"振込先委託者コード","親族・関係者名"})
    private String c25;

    @Column(name="c26")
    @JsonAlias({"振込先金融機関銀行コード","フリガナ（姓）（親族・関係者）"})
    private String c26;

    @Column(name="c27")
    @JsonAlias({"振込先金融機関銀行名（フリガナ）","フリガナ（名）（親族・関係者）"})
    private String c27;

    @Column(name="c28")
    @JsonAlias({"振込先金融機関銀行名","フリガナ（親族・関係者）"})
    private String c28;

    @Column(name="c29")
    @JsonAlias({"振込先金融機関支店コード","性別（親族・関係者）"})
    private String c29;

    @Column(name="c30")
    @JsonAlias({"振込先金融機関支店名（フリガナ）","生年月日（親族・関係者）"})
    private String c30;

    @Column(name="c31")
    @JsonAlias({"振込先金融機関支店名","続柄"})
    private String c31;

    @Column(name="c32")
    @JsonAlias({"振込先口座種別","健康状態"})
    private String c32;

    @Column(name="c33")
    @JsonAlias({"振込先口座番号","職業"})
    private String c33;

    @Column(name="c34")
    @JsonAlias({"振込先口座記号","〒（親族・関係者）"})
    private String c34;

    @Column(name="c35")
    @JsonAlias({"振込先引落日","住所（親族・関係者）"})
    private String c35;

    @Column(name="c36")
    @JsonAlias({"振込先再振替日","住所（地域）（親族・関係者）"})
    private String c36;

    @Column(name="c37")
    @JsonAlias({"振込先契約種別コード","宛先"})
    private String c37;

    @Column(name="c38")
    @JsonAlias({"振込先受入事業所センターコード","電話番号（親族・関係者）"})
    private String c38;

    @Column(name="c39")
    @JsonAlias({"振込先手数料：自行","携帯番号（親族・関係者）"})
    private String c39;

    @Column(name="c40")
    @JsonAlias({"振込先手数料：他行","E-mail（親族・関係者）"})
    private String c40;

    @Column(name="c41")
    @JsonAlias({"初回引落月","連絡先種別"})
    private String c41;

    @Column(name="c42")
    @JsonAlias({"顧客番号","連絡先番号"})
    private String c42;

    @Column(name="c43")
    @JsonAlias({"被保険者番号","優先順"})
    private String c43;

    @Column(name="c44")
    @JsonAlias({"被保険者氏名","申請者"})
    private String c44;

    @Column(name="c45")
    @JsonAlias({"預金者郵便番号","同居家族"})
    private String c45;

    @Column(name="c46")
    @JsonAlias({"預金者氏名","主介護者"})
    private String c46;

    @Column(name="c47")
    @JsonAlias({"預金者住所１","保証人"})
    private String c47;

    @Column(name="c48")
    @JsonAlias({"預金者住所２","支払者"})
    private String c48;

    @Column(name="c49")
    @JsonAlias({"預金者住所３","相談者"})
    private String c49;

    @Column(name="c50")
    @JsonAlias({"身元引受人"})
    private String c50;

    @Column(name="c51")
    @JsonAlias({"配偶者"})
    private String c51;

    @Column(name="c52")
    @JsonAlias({"子"})
    private String c52;

    @Column(name="c53")
    @JsonAlias({"島内協力者"})
    private String c53;

    @Column(name="c54")
    @JsonAlias({"メモ（親族・関係者）"})
    private String c54;

    @Column(name="c55")
    @JsonAlias({"面会"})
    private String c55;

    @Column(name="c56")
    @JsonAlias({"郵便番号（連絡先住所）"})
    private String c56;

    @Column(name="c57")
    @JsonAlias({"住所（連絡先住所）"})
    private String c57;

    @Column(name="c58")
    @JsonAlias({"FAX番号"})
    private String c58;

    @Column(name="time_stamp")
    private Timestamp time_stamp;

    @Column(name="s_id")
    private String s_id;

    @Column(name="p_id")
    private String p_id;

    @Column(name="req_id")
    private String req_id;

    @Column(name="nen")
    private String nen;

    @Column(name="tsuki")
    private String tsuki;

    @Column(name="g_id")
    private String g_id;

    @Column(name="o_id")
    private Integer o_id;

    @PrePersist
    public void onPrePersist() {
    	setTime_stamp(new Timestamp(System.currentTimeMillis()));
    }

    @PreUpdate
    public void onPreUpdate() {
    	setTime_stamp(new Timestamp(System.currentTimeMillis()));
    }
}