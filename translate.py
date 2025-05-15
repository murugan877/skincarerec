import pandas as pd
from googletrans import Translator

# Load your CSV file
df = pd.read_csv('Skin-Care-Recommender-System-main\export_skincare.csv')  # Replace with your actual file name

# Initialize the translator
translator = Translator()

# Function to translate text to English
def translate_text(text):
    try:
        return translator.translate(str(text), dest='en').text
    except:
        return text  # Return original if translation fails

# Translate only the 'description' column
df['description'] = df['description'].map(translate_text)

# Save the translated CSV
df.to_csv('translated_file.csv', index=False)

print("✅ Translation complete. Saved as 'translated_file.csv'")
