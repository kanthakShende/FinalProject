import React from 'react'
import { deleteCustomer } from '../api-client/api-module';

export default function CusCell({data ,setSelect,setSelectItem}) {
    return (
        <div class="entity-item">
            <div >{data.id}</div>
            <div >{data.name}</div>
            <div >{data.contactno}</div>
            <div >
                <button class="update-button" onClick={()=>{
            setSelectItem(data)
            setSelect('update');
        }}>Update</button>
                <button class="delete-button"onClick={async ()=>{
            await deleteCustomer(data.id);
            setSelect('');
        }}>Delete</button>
            </div>
        </div>
    )
}
