package com.iconnic.worktemplate.data;

public class SingletonSession {
    private static SingletonSession instance;
    private static String search,user;
    private static Object thesearch,theuser;
    
    //no outer class can initialize this class's object
    private SingletonSession(){}

    public static SingletonSession Instance()
    {//if no instance is initialized yet then create new instance else return stored instance
        if (instance == null){instance = new SingletonSession();} return instance;
    }
    
    public Object getSearchObj(){return thesearch;} public void setSearchObj(Object thesearch){this.thesearch = thesearch;}
    
    public String getSearch(){return search;} public void setSearch(String search){this.search = search;}
    
    public Object getUserObj(){return theuser;} public void setUserObj(Object thesearch){this.theuser = theuser;}
    
    public String getUser(){return user;} public void setUser(String user){this.user = user;}
}
