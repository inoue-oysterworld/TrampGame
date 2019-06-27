package tramp;

public class Card {//カード
	//フィールド変数、カプセル化
	private String mark;//マーク
	private int number;//番号

	//ゲッターとセッター
	public String getMark(){
		return mark;
	}
	public void setMark(String mark) {
		this.mark=mark;
	}
	public String getNum(){
		String picture;
		switch(this.number) {
		case 1:
			picture="A";
			break;
		case 11:
			picture="J";
			break;
		case 12:
			picture="Q";
			break;
		case 13:
			picture="K";
			break;
		case 14:
			picture="Joker";
			break;
		default:
			picture=String.valueOf(this.number);
		}
		return picture;
	}
	public void setNum(int number) {
		this.number=number;
	}

	//コンストラクタ
	public Card(String mark,int number){
		this.mark=mark;
		this.number=number;

	}
	public Card(){
		this("スペード",1);

	}

	int compareTo(Card anotherCard) {
		int compare;
		int a=this.power();
		int b=anotherCard.power();
		if(a>b) {
			compare=1;
		}else if(a<b){
			compare=-1;
		}else {
			compare=0;
			/*this.getMark();
			anotherCard.getMark();
			if(  ) {

			}*/
		}
		return compare;
	}

	int power() {
		int power;
		switch(this.number) {
		case 1:
			power=14;
			break;
		case 14:
			power=99;
			break;
		default:
			power=this.number;
		}
		return power;
	}










}
