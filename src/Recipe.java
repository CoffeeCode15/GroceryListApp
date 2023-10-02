package GroceryListApp.src;

import java.util.List;

public class Recipe {
    private String name;
    private List<Ingredient> ingredients;
    private List<String> instruction;
    public Recipe(String name, List<Ingredient> ingredients, List<String> instruction){
        this.name=name;
        this.ingredients=ingredients;
        this.instruction=instruction;
    }
    public String getName(){
        return name;
    }

    public List<Ingredient> getIngredients(){
        return ingredients;
    }

    public List<String> getInstruction(){
        return instruction;
    }

}
