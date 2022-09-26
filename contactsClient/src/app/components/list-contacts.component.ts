import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Contact } from '../models';
import { ContactService } from '../services';

@Component({
  selector: 'app-list-contacts',
  templateUrl: './list-contacts.component.html',
  styleUrls: ['./list-contacts.component.css']
})
export class ListContactsComponent implements OnInit, OnDestroy {

  friends: Contact[] = [];
  sub$!: Subscription

  constructor(private contactSvc: ContactService) { }

  ngOnInit(): void {
    console.info(">>>>> getting data")
    this.contactSvc.getContacts().subscribe(result => this.friends = result)
  }

  ngOnDestroy(): void {
  }


}
