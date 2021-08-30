import { MedFromQR } from "./medFromQR";
import { PharmacyForEPrescription } from "./pharmacyForEPrescription";


export class AvailabilityEPrescription{
    prescriptionId!:number;
    medicines: MedFromQR[]=[];
    pharmacies: PharmacyForEPrescription[]=[];
}