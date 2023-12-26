package model;

import java.io.Serializable;
import java.util.List;

public class Video implements Serializable {

	int id;

	private String title;

	private String synopsisShort;

	private String synopsisLong;

	private boolean pcNg;
	
	public List<License> lic;


	public Video(int id, String title, String synopsisShort, String synopsisLong, boolean pcNg) {
		super();
		this.id = id;
		this.title = title;
		this.synopsisShort = synopsisShort;
		this.synopsisLong = synopsisLong;
		this.pcNg = pcNg;
		
	}
	
	/**
	 * ライセンスを設定する
	 * @param lic 追加するライセンス
	 */
	public void setLicenses(List<License> licenses) {
		this.lic = licenses;
	}


	/**
	 * ビデオが持つライセンスのうち、販売中のライセンスを返す。
	 * すべて期間外であれば、販売前のライセンスを返す。
	 * すべて販売終了であれば null。
	 * 複数が期間内ならば、どのライセンスが帰るかは未定義。
	 * @return License
	 */

	public License getValidLicense() {
		License ret = null;
		
		for (License lic : lic) {
				if (! lic.isAfterSale()){// 販売終了でなければ
					// 販売中か、有効なライセンスが見つかってなければ
					if ((! lic.isBeforeSale()) || (ret == null)) {
							ret = lic;
							System.out.println(ret);
					}
				}
		}
		return ret;
	}




	public int getId() {

	return id;

	}

	public String getTitle() {

	return title;

	}

	public String getSynopsisShort() {

	return synopsisShort;

	}

	public String getSynopsisLong() {

	return synopsisLong;

	}

	public boolean isPcNg() {

	return pcNg;

	}

	public List<License> getLic() {
		return lic;
	}



	}