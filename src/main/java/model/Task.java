package model;

import java.security.Timestamp;

public class Task{
	private int id;
    private String title;
    private String description;
    private Timestamp creationDate;
    private Timestamp conclusionDate;
    private String creationDate_Str;
    private String conclusionDate_Str;
    private String status;
    private int idUser;
    
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public Timestamp getCreationDate(){
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate){
		this.creationDate = creationDate;
	}
	public Timestamp getConclusionDate(){
		return conclusionDate;
	}
	public void setConclusionDate(Timestamp conclusionDate){
		this.conclusionDate = conclusionDate;
	}
	public String getStatus(){
		return status;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public int getIdUser(){
		return idUser;
	}
	public void setIdUser(int idUser){
		this.idUser = idUser;
	}
	
	public String getCreationDate_Str(){
		return creationDate.toString();
	}
	public void setCreationDate_Str(String creationDate_Str){
		this.creationDate_Str = creationDate_Str;
	}
	public String getConclusionDate_Str(){
		return conclusionDate.toString();
	}
	public void setConclusionDate_Str(String conclusionDate_Str){
		this.conclusionDate_Str = conclusionDate_Str;
	}
}
