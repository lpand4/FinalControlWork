package org.example.Database;

import org.example.Model.RegistryOfPets;

public interface IDatabase {
    public void saveData(RegistryOfPets rp);
    public RegistryOfPets readDataFromFile();
}
