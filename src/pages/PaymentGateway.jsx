import React, { useEffect, useState } from 'react'
import { getStoreEquipmentById } from '../api-client/api-module';
import { useParams } from 'react-router-dom';
import NavBar from '../component/NavBar';
import Loader from '../component/Loader';
import Footer from '../component/Footer';

export default function PaymentGateway() {
    const { equipmentId } = useParams();
    const [productItem, setProductItem] = useState(null)
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        fetchData();
    }, []);

    const fetchData = async () => {
        try {
            console.log(equipmentId);
            const item = await getStoreEquipmentById(equipmentId);
            setProductItem(item);
            setLoading(false);


        } catch (error) {
            console.error('Error fetching products:', error);
        }
    };

    useEffect(() => {
        if (productItem) {

            const paymentOptions = document.querySelectorAll('input[name="paymentMethod"]');
            const paymentMethodDetails = document.querySelectorAll(".payment-method-details");

            paymentOptions.forEach(option => {
                option.addEventListener("change", function () {
                    paymentMethodDetails.forEach(details => {
                        details.style.display = "none";
                    });

                    const selectedOption = document.querySelector('input[name="paymentMethod"]:checked').value;
                    const selectedDetails = document.getElementById(selectedOption);
                    selectedDetails.style.display = "flex";
                });
            });

        }
    }, [productItem])
    return (
        <>
            <NavBar />
            {loading ? <Loader /> :
                <div className="body-container">
                    <div className="pay-container">
                        <h1>Product Purchase</h1>
                        <div className="product-details-1">
                            <h3>{productItem.name}</h3>
                            <div className="price-container"><h3>Price: ₹ {productItem.productPrice.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 })}</h3></div>
                        </div>
                        <div className="payment-options">
                            <h2>Select Payment Option</h2>
                            <label>
                                <input type="radio" name="paymentMethod" value="upi" />
                                UPI
                            </label>
                            <label>
                                <input type="radio" name="paymentMethod" value="netBanking" />
                                Net Banking
                            </label>
                            <label>
                                <input type="radio" name="paymentMethod" value="cards" />
                                Debit/Credit Card
                            </label>
                        </div>

                        <div className="payment-methods">
                            <div id="upi" className="payment-method-details">
                                <p>Enter UPI ID:</p>
                                <input type="text" id="upiId" className="pay-input" placeholder="yourname@bank" />
                            </div>
                            <div id="netBanking" className="payment-method-details">
                                <p>Select Bank:</p>
                                <select id="bankSelect">
                                    <option value="bank1">Bank 1</option>
                                    <option value="bank2">Bank 2</option>
                                </select>
                            </div>
                            <div id="cards" className="payment-method-details">
                                <p>Enter Card Number:</p>
                                <input type="text" id="cardNumber" placeholder="1234 5678 9012 3456" />
                                <p>Expiration Date:</p>
                                <input type="text" id="expiryDate" placeholder="MM/YY" />
                                <p>CVV:</p>
                                <input type="text" id="cvv" placeholder="123" />
                            </div>
                        </div>

                        <button className="btn">Pay Now</button>

                    </div>
                </div>}
                <Footer/>
        </>
    )
}
