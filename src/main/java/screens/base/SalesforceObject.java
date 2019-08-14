package screens.base;

public abstract class SalesforceObject {

    String newObject;

    public SalesforceObject(){

    }

    public void setNewObject(String newObject){
        this.newObject = newObject;
    }

    public String getNewObject(){
        return this.newObject;

    }

    public void addJsButton(){
        String newObj = getNewObject();
        switch (newObj){
            case "JS BUTTON":
                System.out.println(getNewObject()+" Was selected");
                break;
            case "ACTION":
                System.out.println(getNewObject()+" was selected");
                break;
        }
    }

}
