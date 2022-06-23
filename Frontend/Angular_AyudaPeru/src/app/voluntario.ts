

export class Voluntario {
    id?:              number;
    pais?:            Pais;
    nombre?:          string;
    apellido?:        string;
    direccion?:       string;
    telefono?:        string;
    email?:           string;
    estado?:          boolean;
    numeroDocumento?: string;
    tipoDocumento?:   string;
}

export class Pais {
    idpais?:     number;
    nombrepais?: string;
}

