/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.ocjp.eight.designpatterns.builder;

/**
 *
 * @author mmigdal
 */
public class Entity {

    public final int id;
    public final String name;
    
    
    public Entity (Builder builder){
        this.id = builder.id;
        this.name = builder.name;
    } 
    
    static class Builder {

        private int id;
        private String name;
               
        private Builder() {
        }

        public static Builder get() {
            return new Builder();
        }
        
        public Builder withId(int id) {
            this.id = id;
            return this;
        }
        
        public Builder withName(String name) {
            this.name = name;
            return this;
        }     

        public Entity build (){
            return new Entity(this);
        }
        
        
    }

}
