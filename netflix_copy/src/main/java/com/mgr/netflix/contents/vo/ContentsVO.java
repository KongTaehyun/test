package com.mgr.netflix.contents.vo;

public class ContentsVO {
	private String title;
	private String video_adr;
	private String poster_adr;
	private String detail_poster_adr;
	private String title_img;
	private String summary;
	private String openingdate;
	private String age;
	private String seosons;
	private String quality;
	private String actors;
	private String genre;
	private String feature;
	
	public ContentsVO() {
		// TODO Auto-generated constructor stub
	}


	public ContentsVO(String title, String video_adr, String poster_adr, String detail_poster_adr, String title_img,
			String summary, String openingdate, String age, String seosons, String quality, String actors, String genre,
			String feature) {
		super();
		this.title = title;
		this.video_adr = video_adr;
		this.poster_adr = poster_adr;
		this.detail_poster_adr = detail_poster_adr;
		this.title_img = title_img;
		this.summary = summary;
		this.openingdate = openingdate;
		this.age = age;
		this.seosons = seosons;
		this.quality = quality;
		this.actors = actors;
		this.genre = genre;
		this.feature = feature;
	}


	


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getVideo_adr() {
		return video_adr;
	}


	public void setVideo_adr(String video_adr) {
		this.video_adr = video_adr;
	}


	public String getPoster_adr() {
		return poster_adr;
	}


	public void setPoster_adr(String poster_adr) {
		this.poster_adr = poster_adr;
	}


	public String getDetail_poster_adr() {
		return detail_poster_adr;
	}


	public void setDetail_poster_adr(String detail_poster_adr) {
		this.detail_poster_adr = detail_poster_adr;
	}


	public String getTitle_img() {
		return title_img;
	}


	public void setTitle_img(String title_img) {
		this.title_img = title_img;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}


	public String getOpeningdate() {
		return openingdate;
	}


	public void setOpeningdate(String openingdate) {
		this.openingdate = openingdate;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getSeosons() {
		return seosons;
	}


	public void setSeosons(String seosons) {
		this.seosons = seosons;
	}


	public String getQuality() {
		return quality;
	}


	public void setQuality(String quality) {
		this.quality = quality;
	}


	public String getActors() {
		return actors;
	}


	public void setActors(String actors) {
		this.actors = actors;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getFeature() {
		return feature;
	}


	public void setFeature(String feature) {
		this.feature = feature;
	}


	@Override
	public String toString() {
		return "ContentsVO [title=" + title + ", video_adr=" + video_adr + ", poster_adr=" + poster_adr
				+ ", detail_poster_adr=" + detail_poster_adr + ", title_img=" + title_img + ", summary=" + summary
				+ ", openingdate=" + openingdate + ", age=" + age + ", seosons=" + seosons + ", quality=" + quality
				+ ", actors=" + actors + ", genre=" + genre + ", feature=" + feature + "]";
	}
	
	
}
