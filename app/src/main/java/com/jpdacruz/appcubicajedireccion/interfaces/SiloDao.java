package com.jpdacruz.appcubicajedireccion.interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jpdacruz.appcubicajedireccion.clases.SiloEntity;

import java.util.List;

@Dao
public interface SiloDao {

    @Insert
    void insert(SiloEntity silo);

    @Update
    void update (SiloEntity silo);

    @Query("DELETE FROM silos")
    void deleteAll();

    @Query("DELETE FROM silos WHERE id = :idSiloBorrar")
    void deleteById(int idSiloBorrar);

    @Query("SELECT * FROM silos ORDER BY idSilo ASC")
    LiveData<List<SiloEntity>> getAll();
}
