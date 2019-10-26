package me.marsonix.core.users.operators;

import me.marsonix.core.users.DefaultUser;
import me.marsonix.core.users.Level;
import me.marsonix.core.users.interfaces.events.operators.OperatorLoadEvent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class OperatorUser extends DefaultUser {

    protected List<Permission> permissions = new ArrayList<>();

    public OperatorUser(String name) {
        super(name);
    }

    public OperatorUser(String name, Level level) {
        super(name, level);
    }

    public OperatorUser(String name, BigDecimal money) {
        super(name, money);
    }

    public OperatorUser(String name, Level level, BigDecimal money) {
        super(name, level, money);
    }


    public List<Permission> getPermissions(){
        return permissions;
    }

    public void addPermission(Permission perm){
        if(permissions.contains(perm)) return;
        permissions.add(perm);
    }
    public void removePermission(Permission perm){
        if(!permissions.contains(perm)) return;
        permissions.remove(perm);
    }

    public abstract String specialPrefix();

    public void load(OperatorLoadEvent event) {
        //event.setOperatorUser(this);
    }

}
