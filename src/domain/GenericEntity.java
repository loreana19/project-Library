/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author LORA
 */
public interface GenericEntity extends Serializable{

    String getTableName();

    String getColumnNamesForInsert();

    String  getInsertedValues();

    void setId(Long id);

    String getWhereClauseDeleteEdit();

    String getJoinClause();

    String getColumnNamesForGetAll();

    String getWhereForGetAll();

    String getColumnNamesValuesUpdate();

    String getAlias();

   
    
}
