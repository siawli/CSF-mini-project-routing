import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Contact } from '../models';
import { ContactService } from '../services';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {

  form!: FormGroup;

  constructor(private fb: FormBuilder,
      private contactSvc: ContactService,
      private router: Router) { }

  ngOnInit(): void {
    this.form = this.createForm();
  }

  createForm(): FormGroup {
    return this.fb.group({
      name: this.fb.control<string>('', [Validators.required, Validators.minLength(3)]),
      email: this.fb.control<string>('', [Validators.required, Validators.email]),
      mobile: this.fb.control<number>(0, [Validators.required, Validators.minLength(8)])
    })
  }
  
  processForm() {
    const c: Contact = this.form.value as Contact;
    // console.info(">>>> processing form: " + c);
    this.contactSvc.saveContact(c)
      .then(result => console.info(result))
      .catch(error => console.info(error))
    this.form.reset();
    this.router.navigate(['/listContacts'])
  }
}
