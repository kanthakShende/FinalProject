import React from 'react'

export default function Footer() {
  return (
    <div className="footer-container">
        {/* <div className="barnd-name"><a href="/"><span>Fitsta</span>.com</a></div> */}
        <div className="divider-y"></div>
        <div className="social-icons">
            <img src="/img/facebook-round-color-icon.svg" alt="" />
            <img src="/img/instagram-round-color-icon.svg" alt="" />
            <img src="/img/whatsapp-round-color-icon.svg" alt="" />
            <img src="/img/twitter-round-color-icon.svg.svg" alt="" />
        </div>
        <div className="copy-line">
            <p>&copy; 2023 Fitsta.com All rights reserved.</p>
        </div>
    </div>
  )
}
