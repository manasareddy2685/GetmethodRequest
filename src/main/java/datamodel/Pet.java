package datamodel;
import java.util.List;
public class Pet{
        int id;
        PetCategory category;
        String name;
        List<String> photoUrls;
        List<PetTags> tags;
        String status;
        public int getId() { return id;}
        public void setId(int id) { this.id = id;}
        public PetCategory getCategory() { return category;}


        public String getName() { return name;}
        public void setCategory(PetCategory petCategory){ this.category = petCategory;}
        public List<String> getPhotoUrls() { return photoUrls; }

        public void setPhotoUrls(List<String> photoUrls) { this.photoUrls = photoUrls;}
        public List<PetTags> getTags() { return tags;}
        public void setTags(List<PetTags> tags) { this.tags = tags;}
        public String getStatus() { return status;}
        public void setStatus(String status) { this.status = status;}

        public void setName(String petname) {
        }
}


