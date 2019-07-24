package com.smartnerd.model;

import java.io.Serializable;

public interface EmployeeInterface <T extends Serializable> {
T getCity();
}
