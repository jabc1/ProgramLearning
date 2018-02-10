import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * ��Doubleֵ������λС���ķ����ܽ�
 * 
 * @author Administrator
 *
 */
public class DoubleFormat {
	public static void main(String[] args){
		DoubleFormat df = new DoubleFormat();
		System.out.println(df.formatMethodByRound(111.2212342));
	}

	//���࣬��������ת��ת��
	public Double formatMethodByRound(Double value){
		return Math.round(value * 100) / 100.0;
	}
	
	// ���ô�����ķ���
	public Double formatMethodByBigDecimal(Double value){
		return (new BigDecimal(value).setScale(2, RoundingMode.HALF_UP)).doubleValue();
	}
	
	// ͨ�õĸ�ʽ������,��������ת���͸�ʽ��
	public Double formatMehtodByStringFormat(Double value){
		return Double.parseDouble(String.format("%1$.2f", value));
	}
	
	// ��רҵ��ʽ�������������ø���NumberFormat����Locale
	public Double formatMehtodByDecimalFormat(Double value){
		return Double.parseDouble((new DecimalFormat("#0.00")).format(value));
	}
	
	// ��԰ٷֱȣ�������Ҫ���ٷֱ������������������ֵ���
	public Double formatMethodBy(Double value){
		DecimalFormat df2 = (DecimalFormat)DecimalFormat.getPercentInstance();
		df2.setMaximumFractionDigits(2);
		return Double.parseDouble(df2.format(value));
	}
}
