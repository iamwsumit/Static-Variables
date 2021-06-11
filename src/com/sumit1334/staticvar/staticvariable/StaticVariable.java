package com.sumit1334.staticvar.staticvariable;

import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.YailList;

import java.util.HashMap;

public class StaticVariable extends AndroidNonvisibleComponent {
  private static HashMap<String ,Object> variables=new HashMap<>();

  public StaticVariable(ComponentContainer container) {
    super(container.$form());
  }

  @SimpleFunction
  public void Initialise(String name,Object value){
    this.variables.put(name,value);
  }
  @SimpleFunction
  public boolean IsVariableExist(String name){
    return this.variables.containsKey(name);
  }
  @SimpleFunction
  public int GetAllVariable(){
    return this.variables.keySet().size();
  }
  @SimpleFunction
  public YailList GetAllNames(){
    return YailList.makeList(this.variables.keySet());
  }
  @SimpleFunction
  public YailList GetAllValue(){
    return YailList.makeList(this.variables.values());
  }
  @SimpleFunction
  public void Set(String name,Object value){
    this.variables.replace(name, value);
  }
  @SimpleFunction
  public Object GetValue(String name){
    return this.variables.get(name);
  }
  @SimpleFunction
  public void Remove(String name){
    if (this.variables.containsKey(name))
      this.variables.remove(name);
  }
  @SimpleFunction
  public void Rename(String oldName,String newName){
    if (variables.containsKey(oldName))
      variables.replace(newName,variables.get(oldName));
  }
  @SimpleFunction
  public void RemoveAll(){
    variables.clear();
  }

}
