package com.deputy.assignment.service;

import com.deputy.assignment.data.provider.RoleDataAccessObject;
import com.deputy.assignment.model.Role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RoleService {


    private Map<Integer, List<Integer>> roleMappingData = new HashMap<>();

    private RoleDataAccessObject roleDataAccessObject;

    public RoleService(RoleDataAccessObject roleDataAccessObject) {
        this.roleDataAccessObject = roleDataAccessObject;
    }

    /**
     * find all roles immediate and further down the hierarchy
     * @param parentRoleId
     * @return
     */
    public List<Integer> getSubRolesByParentId(int parentRoleId){
        List<Integer> subRoleIds = roleMappingData.get(parentRoleId);
        if(subRoleIds == null){
            List<Role> subRoles = roleDataAccessObject.findSubRolesByParentId(parentRoleId);

            if(subRoles != null && !subRoles.isEmpty()){
                subRoleIds = subRoles.stream().map(r->r.getId()).collect(Collectors.toList());
                roleMappingData.put(parentRoleId,subRoleIds);
            }
        }
       return subRoleIds;
    }


}
