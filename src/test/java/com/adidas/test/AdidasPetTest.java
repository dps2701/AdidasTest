package com.adidas.test;


import java.util.ArrayList;
import java.util.List;


 
public class AdidasPetTest {
 
	   private long id;
		
		private AdidasPetTestCategory category;
		
		private String name;
		
		private List<String> photoUrls = new ArrayList<String>();
		
		private List<AdidasPetTestTag> tags = new ArrayList<AdidasPetTestTag>();
		
		private String status;

		public long getId() {
		return id;
		}

		public void setId(long id) {
		this.id = id;
		}

		public AdidasPetTestCategory getCategory() {
		return category;
		}

		public void setCategory(AdidasPetTestCategory category) {
		this.category = category;
		}

		public String getName() {
		return name;
		}

		public void setName(String name) {
		this.name = name;
		}

		public List<String> getPhotoUrls() {
		return photoUrls;
		}

		public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
		}

		public List<AdidasPetTestTag> getTags() {
		return tags;
		}

		public void setTags(List<AdidasPetTestTag> tags) {
		this.tags = tags;
		}

		public String getStatus() {
		return status;
		}

		public void setStatus(String status) {
		this.status=status;
		}
}
