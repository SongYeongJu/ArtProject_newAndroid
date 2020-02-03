package com.example.newartproject.Client;

import com.example.newartproject.Data.Taste;
import com.example.newartproject.Data.User;
import com.example.newartproject.Data.mPicture;
import com.example.newartproject.R;

import java.util.ArrayList;

public class ClientInfoManager {
    static private ClientInfoManager Instance= new ClientInfoManager();
    static public ClientInfoManager getInstance() {
        if(Instance==null) Instance=new ClientInfoManager();
        return Instance;
    }
    private User user;
    private ArrayList<mPicture> pictures;
    private ArrayList<mPicture> recommendPictures;
    private ArrayList<Taste> tastes;


    public ClientInfoManager(){
        user=new User();
        pictures=new ArrayList<mPicture>();
        recommendPictures=new ArrayList<mPicture>();
        tastes=new ArrayList<Taste>();

        setTestPictureSet();
        setTestRecommendPictureSet();
        setTestTasteSet();
    }
    public void setUser(User user){
        this.user=user;
    }
    public void setPictures(ArrayList<mPicture> pictures) {this.pictures=pictures;}
    public void setRecommendPictures(ArrayList<mPicture> pictures) {this.recommendPictures=pictures;}
    public void setTastes(ArrayList<Taste> tastes) { this.tastes=tastes; }

    public void addPicture(mPicture picture) { pictures.add(picture);}
    public void addRecommendPicture(mPicture picture) { recommendPictures.add(picture);}
    public void addTaste(Taste taste) {tastes.add(taste);}

    public User getUser() { return user; }
    public ArrayList<mPicture> getPictures(){ return pictures;}
    public ArrayList<mPicture> getRecommendPictures(){ return recommendPictures;}
    public ArrayList<Taste> getTastes(){ return tastes;}

    public void setTestTasteSet() {
        tastes.add(new Taste("한국 화가",R.drawable.ba1));
        tastes.add(new Taste("인상파",R.drawable.ba1));
        tastes.add(new Taste("유화",R.drawable.ba1));
        tastes.add(new Taste("졸업 작품",R.drawable.ba1));
        tastes.add(new Taste("신인 작품",R.drawable.ba1));
        tastes.add(new Taste("고가의 작품",R.drawable.ba1));
        tastes.add(new Taste("저가의 작품",R.drawable.ba1));
        tastes.add(new Taste("오래된 작품",R.drawable.ba1));
        tastes.add(new Taste("새로나온 작품",R.drawable.ba1));
    }


    public void setTestRecommendPictureSet() {
        int[] src ={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8,R.drawable.image9,R.drawable.image10,R.drawable.image11,R.drawable.image12};
        for(int i=0;i<11;i++) {
            recommendPictures.add(new mPicture("id"+i, "name"+i, "artist"+i, i*100, src[i], null));
        }
        recommendPictures.add(new mPicture("id1", "name1", "artist1", 100, R.drawable.ba1, null));
        recommendPictures.add(new mPicture("id2", "name2", "artist2", 200, R.drawable.ba2, null));
        recommendPictures.add(new mPicture("id3", "name3", "artist3", 300, R.drawable.ba3, null));
    }
    public void setTestPictureSet() {
        int[] src ={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8,R.drawable.image9,R.drawable.image10,R.drawable.image11,R.drawable.image12};
        for(int i=10;i>-1;i--) {
            pictures.add(new mPicture("id"+i, "name"+i, "artist"+i, i*100, src[i], null));
        }
        for(int i=0;i<11;i++) {
            pictures.add(new mPicture("id"+i, "name"+i, "artist"+i, i*100, src[i], null));
        }
        pictures.add(new mPicture("id1", "name1", "artist1", 100, R.drawable.ba1, null));
        pictures.add(new mPicture("id2", "name2", "artist2", 200, R.drawable.ba2, null));
        pictures.add(new mPicture("id3", "name3", "artist3", 300, R.drawable.ba3, null));
    }

    //TO-DO : create method for changing user's information
}
