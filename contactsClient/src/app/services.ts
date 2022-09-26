import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom, Observable, Subject } from "rxjs";
import { Contact } from "./models";

@Injectable()
export class ContactService {

    constructor(private httpClient: HttpClient) { }

    listContacts = new Subject<Contact[]>();

    public saveContact(c : Contact): Promise<any> {
        // console.info("contact: " + c.name + " " + c.email + " " + c.mobile);
        return firstValueFrom(
            this.httpClient.post<void>('/contacts/addContact', c)
        )
    }

    // public getContacts(): Promise<Contact[]> {
    //     return firstValueFrom(
    //         this.httpClient.get<Contact[]>('/contacts/listContacts')
    //     )
    // }

    public getContacts(): Observable<Contact[]> {
        return this.httpClient.get<Contact[]>('/contacts/listContacts')
    }

}