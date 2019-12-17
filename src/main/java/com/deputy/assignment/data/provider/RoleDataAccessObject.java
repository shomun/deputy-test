package com.deputy.assignment.data.provider;

import com.deputy.assignment.model.Role;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 *
 */
public class RoleDataAccessObject {
    private DataStore dataStore;

    public RoleDataAccessObject(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    /**
     * find a role for a given role id
     * @param roleId
     * @return
     */
    public Role findRoleById(int roleId){
        Optional<Role> role = dataStore.getRoles().stream().filter(u-> u.getId() == roleId).findFirst();
        return (role.isPresent()) ? role.get() : null;
    }

    /**
     * find all sub roles (immediate and down the hierarchy ) for a fiven role id
     * @param parentRoleId
     * @return
     */
    public List<Role> findSubRolesByParentId(int parentRoleId){
       return findImmediateSubRoles(parentRoleId,dataStore.getRoles());
    }

    /**
     * Find all the sub roles recursively util it reaches the last role(s) in the hierarchy
     * @param parentRoleId
     * @param roles
     * @return
     */
    private List<Role> findImmediateSubRoles(int parentRoleId, List<Role> roles){
        List<Role> subRoles = roles.stream().filter(r->r.getParentId() == parentRoleId).collect(Collectors.toCollection(CopyOnWriteArrayList::new));
        Iterator<Role> roleIterator = subRoles.iterator();
         subRoles.forEach( subRole->{
            List<Role> immidiateSubRoles = findImmediateSubRoles(subRole.getId(), roles);
            subRoles.addAll(immidiateSubRoles);
        });
        return subRoles;
    }
}
