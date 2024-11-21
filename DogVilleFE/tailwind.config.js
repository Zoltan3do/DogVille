/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors:{
        'primary-color': ' #111C20',
        'whiteino':'#E0E2E2',
        'reddino':'#AF9A9B'
      }
    },
  },
  plugins: [],
}

