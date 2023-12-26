package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class License implements Serializable  {
    private int id;
    private LocalDateTime purchaseStartDate;
    private LocalDateTime purchaseEndDate;
    private int price;

  /* 省略。通常のゲッターを記入  */
    public int getId() {
	    return id;
    }
    public LocalDateTime getPurchaseStartDate() {
        return purchaseStartDate;
    }
    public LocalDateTime getPurchaseEndDate() {
        return purchaseEndDate;
    }
    public int getPrice() {
        return price;
    }

  /* YYYY年MM月DD日のフォーマットで表示するカスタムゲッター */
    public String getFormattedPurchaseStartDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年M月d日");
        return dtf.format(getPurchaseStartDate());
    }

    public String getFormattedPurchaseEndDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年M月d日");
        return dtf.format(getPurchaseEndDate());
    }

    public License(int id, LocalDateTime purchaseStartDate, LocalDateTime purchaseEndDate,int price) {
        super();
        this.id = id;
        this.purchaseStartDate = purchaseStartDate;
        this.purchaseEndDate = purchaseEndDate;
        this.price = price;
        /* 省略。変数に引数の値をセット */
    }
    
    /**
     * ライセンスが販売期間前かどうかを返す
     * @return boolean 販売期間前ならtrue
     */
    public boolean isBeforeSale() {
        return getPurchaseStartDate().isAfter(LocalDateTime.now());
    }
    /**
     * ライセンスが販売期間後かどうかを返す
     * @return boolean 販売期間前ならtrue
     */
    public boolean isAfterSale() {
        return getPurchaseEndDate().isBefore(LocalDateTime.now());
    }
}

