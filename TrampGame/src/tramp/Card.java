package tramp;

public class Card {//カード
	//フィールド変数、カプセル化
	private String mark;//マーク
	private String number;//番号

	//ゲッターとセッター
	public String getMark(){
		return mark;
	}
	public void setMark(String mark) {
		this.mark=mark;
	}
	public String getNumber(){
		return number;
	}
	public void setNum(String number) {
		this.number=number;
	}

	//コンストラクタ
	public Card(String mark,String number){
		this.mark=mark;
		this.number=number;

	}
	public Card(){
		this("スペード","A");

	}









}
