package projetGMAO2;


import java.time.LocalDate;

public class Maintenance {

    /** 
     * référence du numéroIFU
     */
    private int MaintenanceId;    
    /**
     * Nom de l'opérateur
     */
    private int OperateurId;    
    /**
     * Type de maintenance
     */
    private String typeMaintenance;    
    /**
     * Description de la maintenance
     */
    private String Description;
    
    /**
     * Equipement concerné
     */
    private String Equipement;
    
    /**
     * Date de la maintenance
     */
    private LocalDate Date;

    /**
     * Constructeur
     * @param MaintenanceId Identifiant de la maintenance
     * @param nomOperateur Nom de l'opérateur
     * @param typeMaintenance Type de maintenance
     * @param Description Description de la maintenance
     * @param equipement Equipement concerné
     * @param Date Date de la maintenance
     */
    public Maintenance(int MaintenanceId, int OperateurId, String typeMaintenance, String Description, String Equipement, LocalDate Date) {
        this.MaintenanceId = MaintenanceId;
        this.OperateurId = OperateurId;
        this.typeMaintenance = typeMaintenance;
        this.Description = Description;
        this.Equipement = Equipement;
        this.Date = Date;
    }
    
    /**
     * getter pour l'attribut MaintenanceId
     * @return valeur de MaintenanceId
     */
    public int getMaintenanceId() {
        return MaintenanceId;
    }
    
    /**
     * setter pour l'attribut MaintenanceId
     * @param MaintenanceId nouvelle valeur de MaintenanceId
     */
    public void setMaintenanceId(int MaintenanceId) {
        this.MaintenanceId = MaintenanceId;
    }
    
    /**
     * getter pour l'attribut nomOperateur
     * @return valeur de nomOperateur
     */
    public int getOperateurId() {
        return OperateurId;
    }
    
    /**
     * setter pour l'attribut nomOperateur
     * @param nomOperateur nouvelle valeur de nomOperateur
     */
    public void setOperateurId(int OperateurId) {
        this.OperateurId = OperateurId;
    }

    /**
     * getter pour l'attribut typeMaintenance
     * @return valeur de typeMaintenance
     */
    public String getTypeMaintenance() {
        return typeMaintenance;
    }
    
    /**
     * setter pour l'attribut typeMaintenance
     * @param typeMaintenance nouvelle valeur de typeMaintenance
     */
    public void setTypeMaintenance(String typeMaintenance) {
        this.typeMaintenance = typeMaintenance;
    }

    /**
     * getter pour l'attribut Description
     * @return valeur de Description
     */
    public String getDescription() {
        return Description;
    }
    
    /**
     * setter pour l'attribut Description
     * @param Description nouvelle valeur de Description
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * getter pour l'attribut equipement
     * @return valeur de equipement
     */
    public String getEquipement() {
        return Equipement;
    }
    
    /**
     * setter pour l'attribut equipement
     * @param equipement nouvelle valeur de equipement
     */
    public void setEquipement(String equipement) {
        this.Equipement = equipement;
    }

    /**
     * getter pour l'attribut Date
     * @return valeur de Date
     */
    public LocalDate getDate() {
        return Date;
    }
    
    /**
     * setter pour l'attribut Date
     * @param Date nouvelle valeur de Date
     */
    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    /**
     * Redéfinition de la méthode toString permettant de définir la traduction de l'objet en String
     * pour l'affichage par exemple
     */
    @Override
    public String toString() {
        return "Maintenance [Identifiant : " + MaintenanceId + 
               ", Nom de l'Opérateur : " + OperateurId + 
               ", Type de Maintenance : " + typeMaintenance + 
               ", Description : " + Description + 
               ", Equipement : " + Equipement + 
               ", Date : " + Date + "]";
    }
}

