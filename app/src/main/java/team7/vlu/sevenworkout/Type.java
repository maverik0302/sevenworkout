package team7.vlu.sevenworkout;

public class Type {
  private String name;
  private int photo;

    public Type() {
    }

    public Type(String name, int photo) {
        this.name = name;
        this.photo = photo;
    }

    //getter

    public String getName() {
        return name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
