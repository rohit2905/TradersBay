import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private storageName:string = "id";
  constructor(private http:HttpClient) { }

  setSettings(data:any){
    localStorage.setItem(this.storageName,JSON.stringify(data));
  }
 getUserSettings(){
   let data = localStorage.getItem(this.storageName);
   return JSON.stringify(data);
 }
 clearUserSettings(){
   localStorage.removeItem(this.storageName);
 }
 cleanAll(){
   localStorage.clear();
 }




}
